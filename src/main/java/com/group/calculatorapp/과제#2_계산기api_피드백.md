# 과제#2 피드백

[1번 과제] - 
사칙연산을 하는 간단한 기능이었죠! 많은 분들께서 사칙 연산 코드를 Controller에 놓기도 하시고~ 아니면 DTO에 놓기도 하셨어요! 저라면 DTO 쪽에 사칙연산 기능을 넣는 방법을 선택할거에요! 아마 조금 더 진도를 나가면 Controller - Service - Repository 계층 구조를 다루게 될텐데,
스프링 코드를 작성하면서 신경쓰게 되는 것 중 하나가 Service 계층의 코드를 깔끔하게 만드는 것이고, Service 계층의 코드를 깔끔하게 만들기 위해서는 일부 계산 로직을 DTO 쪽으로 넣는 방법을 사용할 수도 있거든요! 😊  그래서 저라면 DTO 쪽에 로직을 넣었을 겁니다.

개선한 DTO
```java
    public CalculatorResponse(CalculatorRequest request) {
        this.add = request.getNum1() + request.getNum2();
        this.minus = request.getNum1() - request.getNum2();
        this.multiply = request.getNum1() * request.getNum2();
    }


```
[2번 과제] -

날짜를 받는 기능이었는데요~ LocalDate를 한 번 사용해보시라고 넣었어요~ @DateTimeFormat 을 사용해주신 분도 계시고,
String으로 받아서 파싱해주신 분도 계시네요! 저라면 들어오는 query parameter가 1개 라서 (상황에 따라 조금씩 다를 수 있지만) 그냥 바로 LocalDate 를 사용해서 요청을 받을 것 같아요. 스프링 버전에 따라 앞서 언급드린 방법을 사용해야 할 수 있습니다!
```java
@GetMapping("/date")
public void getDayOfTheWeek(LocalDate date)
```


[3번 과제] 
- 이번에는 List를 받아보도록 연습하는 과제였는데요! POST API + List 필드가 있는 DTO를 사용하시면 쉽게 해결하실 수 있습니다! 👍  참고로, GET API에서도 List로 바로 필드를 받을 수 있으니 궁금하신 분들은 해보셔도 좋을 것 같아요~
- POST / GET / PUT 과 같은 HTTP method와 관련해서 아래 질문을 함께 읽어보셔도 좋습니다. (https://www.inflearn.com/questions/1175426/수정이라는-작업을-할-때-put을-더-사용하는-이유가-있을까요)