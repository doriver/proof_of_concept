import requests

# 요청을 보낼 URL
url = "http://localhost:9880/parse.test"

# 전송할 JSON 데이터
data_list = [
    {"vendor":"fortigateUTM","@timestamp":"2025-10-13","message":"BOAN_Master","source.ip":"198.55.98.201","destination.ip":"61.110.14.40","event.kind":"traffic","event.category":"forward"},
    {"vendor":"fortigateUTM","@timestamp":"2025-10-13","message":"BOAN_Master","source.ip":"203.240.129.209","destination.ip":"58.180.85.66","event.kind":"traffic","event.category":"local"},
    {"vendor":"ahnlabUTM","@timestamp":"2025-10-13","message":"UTM_DEFAULT","source.ip":"111.12.13.123","destination.ip":"66.100.44.60","event.kind":"firewall","event.category":"allow"},
    {"vendor":"ahnlabUTM","@timestamp":"2025-10-13","message":"UTM_GEOIP","source.ip":"222.33.44.201","destination.ip":"66.110.44.40","event.kind":"firewall","event.category":"deny"},
]

# 순서대로 요청
for data in data_list:
    response = requests.post(url, json=data, timeout=10)
    print("요청 데이터:", data)
    print("응답 코드:", response.status_code)
    print("응답 내용:", response.text)
    print("="*40)
