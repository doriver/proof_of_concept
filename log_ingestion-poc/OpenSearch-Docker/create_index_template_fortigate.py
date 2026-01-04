import requests

baseUrl = "http://localhost:9200/"
templateName = "log-fortigate-traffic"
template = {
  "index_patterns": ["log-fortigate-traffic-*"],
  "template": {
    "mappings": {
      "properties": {
        "@timestamp": { "type": "date" }, 
        "message":   { "type": "match_only_text" },
        "source.ip": {"type": "ip"},
        "destination.ip": {"type": "ip"},
        "event.kind": {"type": "keyword"},
        "event.category": {"type": "keyword"}
      }
    }
  },
  "priority": 1
}

# 템플릿 생성
response = requests.put(baseUrl + "_index_template/" + templateName, json=template) 

# 응답 내용 확인
print("응답 코드:", response.status_code)
print("응답 본문:", response.text)