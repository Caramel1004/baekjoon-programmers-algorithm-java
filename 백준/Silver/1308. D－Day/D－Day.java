import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] normalYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] leapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] today = br.readLine().split(" ");
        String[] dDay = br.readLine().split(" ");

        int todayYear = Integer.parseInt(today[0]);
        int todayMonth = Integer.parseInt(today[1]);
        int todayDay = Integer.parseInt(today[2]);

        int dDayYear = Integer.parseInt(dDay[0]);
        int dDayMonth = Integer.parseInt(dDay[1]);
        int dDayDay = Integer.parseInt(dDay[2]);

        int remainDay = 0;// 남은 일 수

        // (오늘이 y년 m월 d일이고, D-Day가 y+1000년 m월 d일과 같거나 늦다면) "gg"를 출력한다.
        if ((dDayYear == todayYear + 1000 && dDayMonth >= todayMonth && dDayDay >= todayDay)
                || dDayYear > todayYear + 1000) {
            System.out.print("gg");

        } else {

            // 오늘 날짜 년도와 디데이 날짜 년도 사이 년도의 일 수
            if (dDayYear - todayYear > 1) {
                for (int year = todayYear + 1; year < dDayYear; year++) {
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        remainDay += 366;// 윤년
                    } else {
                        remainDay += 365;// 평년
                    }
                }
            }

            // 같은 년도 일 때
            if (todayYear == dDayYear) {
                // 같은 년도 and 같은 달(월)
                if (todayMonth == dDayMonth) {
                    remainDay += dDayDay - todayDay;
                } else {// 같은 년도 and 같은 달 아닌 경우
                    for (int month = todayMonth; month <= dDayMonth; month++) {// 윤년 일 때
                        if ((todayYear % 4 == 0 && todayYear % 100 != 0) || todayYear % 400 == 0) {
                            if (month == todayMonth) {// 오늘 날짜 달인 경우
                                remainDay += leapYear[month - 1] - todayDay + 1;
                            } else if (month != dDayMonth) {// 오늘 날짜 달이 아닌 경우
                                remainDay += leapYear[month - 1];
                            } else if (month == dDayMonth) {// 디데이 날짜 달인 경우
                                remainDay += dDayDay - 1;
                            }
                        } else {// 평년 일 때
                            if (month == todayMonth) {
                                remainDay += normalYear[month - 1] - todayDay + 1;
                            } else if (month != dDayMonth) {
                                remainDay += normalYear[month - 1];
                            } else if (month == dDayMonth) {
                                remainDay += dDayDay - 1;
                            }
                        }
                    }
                }

            } else {// 같은 년도 아닐 떄

                // 오늘 날짜 부터 이번년도 12월 까지의 일 수 모두 더하는 알고리즘
                for (int month = todayMonth; month <= 12; month++) {
                    if ((todayYear % 4 == 0 && todayYear % 100 != 0) || todayYear % 400 == 0) {
                        if (month == todayMonth) {
                            remainDay += leapYear[month - 1] - todayDay + 1;
                        } else {
                            remainDay += leapYear[month - 1];
                        }
                    } else {
                        if (month == todayMonth) {
                            remainDay += normalYear[month - 1] - todayDay + 1;
                        } else {
                            remainDay += normalYear[month - 1];
                        }
                    }
                }

                // 1월부터 디데이 날짜 달 까지의 일 수 모두 더하는 알고리즘
                for (int month = 1; month <= dDayMonth; month++) {
                    if ((dDayYear % 4 == 0 && dDayYear % 100 != 0) || dDayYear % 400 == 0) {
                        if (month == dDayMonth) {// 디데이 날짜의 달인 경우
                            remainDay += dDayDay - 1;
                        } else {
                            remainDay += leapYear[month - 1];
                        }
                    } else {// 평년 일 때
                        if (month == dDayMonth) {
                            remainDay += dDayDay - 1;
                        } else {
                            remainDay += normalYear[month - 1];
                        }
                    }
                }
            }

            System.out.print("D-" + remainDay);
        }

    }
}
