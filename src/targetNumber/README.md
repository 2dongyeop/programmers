## 프린터

----
[개인 노션 링크](https://leedongyeop.notion.site/target-number-d1b659de0dcf453a8894c5deba0a60aa)

[문제 원본 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43165)
<br/>

#### [문제 설명]

n개의 음이 아닌 정수들이 있습니다. 
이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

- -1+1+1+1+1 = 3
- +1-1+1+1+1 = 3
- +1+1-1+1+1 = 3
- +1+1+1-1+1 = 3
- +1+1+1+1-1 = 3

<br/>

- numbers : 사용할 수 있는 숫자가 담긴 배열
- target : 만드려는 타겟 넘버 

매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

<br/>

#### [예시]

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기 목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.

<br/>


#### [제한사항]

- 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
- 각 숫자는 1 이상 50 이하인 자연수입니다.
- 타겟 넘버는 1 이상 1000 이하인 자연수입니다.

<br/>


#### [입출력 예]
|numbers |	target |return |
|:--------:|:---------:|:-------:|
|[1, 1, 1, 1, 1]	| 2    |       5|
|[4, 1, 2, 1]	| 4|	    2|