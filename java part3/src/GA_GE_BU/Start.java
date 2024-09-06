package GA_GE_BU;

/*
가계부 1 (collection 사용
기능
AccountBook[i]
AccountBookimpl
start

1. 가계부 내역 추가
예)
공책:1000원
연필:300원
합계:1300원

2. 내역조회
-> 과거 날짜 제목들 리스트가 나온다.
2024-09-04
2024-09-03
2024-09-02
...
-> 제목을 입력하면(2024-09-04)해당 날짜의 내역들이 나온다.

3. 전체 삭제
- 제목을 입력한 날짜와 내역을 삭제

4. 내역 삭제
- 내역들 중 특정 항목을 삭제 시킬 수 있다.

5. 프로그램 종료
---------------------------------------------------------------------------------------------------
가계부 2 (File I/O 사용
기능
AccountBook[i]
AccountBookimpl
start

1. 가계부 내역 추가
-> 오늘 날짜의 파일(.txt)이 없으면 자동으로 생성한다.
-> 있으면 기존 내역에 해당 내용을 추가한다.
-> 추가 형식 :
예)
공책:1000원
연필:300원
합계:1300원

2. 내역조회
-> 과거 날짜 제목들 리스트가 나온다.
2024-09-04
2024-09-03
2024-09-02
...
-> 제목을 입력하면(2024-09-04)해당 날짜의 내역들이 나온다.

3. 삭제
- 제목을 입력한 파일 삭제

4. 프로그램 종료
 */

public class Start {
    public static void main(String[] args) {
        AccountBook gagebu = new AccountBookimpl();

        while(true) {
            int menuNum = gagebu.printMenu();
            switch(menuNum) {
                case 1:
                    gagebu.plusNeuk();
                    break;
                case 2:
                    gagebu.printHistory();
                    break;
                case 3:
                    gagebu.allClear();
                    break;
                case 4:
                    gagebu.neukClear();
                    break;
                case 5:
                    System.out.println("가계부를 닫았다.");
                    return;

            }
        }
    }
}
