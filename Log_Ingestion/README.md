# Log_Ingestion
여러 보안제품에서 수집된 다양한Log들을 Opensearch에 저장 
<img width="2223" height="532" alt="image" src="https://github.com/user-attachments/assets/8f8c536c-50f0-44f4-b7f9-bcc81fc7a2af" />
   
* Log Ingestion에대한 Proof of Concept
    * Fluentd에 모인 보안Log들을 Json으로 파싱해 Opensearch에 저장
    * docker-compose로 OpenSearch 실행
        * Node1, Node2, Dashboard(로그 시각화)
    * log-(보안제품)-(로그유형)-(년).(월).(일) 형태로 index 생성
        * OpenSearch에서 log-(보안제품)-(로그유형)-* 형태로 index_template을 생성
        * Fluentd에서 로그 유형별로 log-(보안제품)-(로그유형)-(년).(월).(일) 형태로 index_name을 지정
    * python으로 간단한 테스트 환경 - Fluentd에게 HTTP요청 보냄
* Fluentd에서 수많은 종류의 로그들 JSON으로 파싱하는 로직 개발
    * 각 벤더사Log 별로 tag를 다르게 붙여, 자료구조 Tree느낌으로 분기되어   
    여러 벤더사Log들 동시에 파싱하도록 개발
    * 데이터 형태 분석 → 파싱전략 수립
        * 정규표현식 이용
        * CSV, LTSV형식의 데이터를 JSON으로 바꿔주는 기능 이용
        * 아래 그림은 파싱 전략의 큰 흐름(실제 로직은 더 복잡)
<img width="882" height="271" alt="image" src="https://github.com/user-attachments/assets/27a1f72f-4d9e-45d4-a8cb-0e7974f7a4ec" />




