class Solution {
    public StringBuilder solution(String str) {
        // 1. 문자열 배열로 변환
        String[] strArr = str.split("\\s");

        // 2. 첫글자만 대문자로 변환
        for(int index = 0; index < strArr.length; index++) {
            // 배열 길이 0이면 
            if(strArr[index].isEmpty()) {
                continue;
            }
            
            // 문자열의 문자를 소문자로 모두 변환
            strArr[index] = strArr[index].toLowerCase();

            // 문자 배열로 변환
            char[] charArr = strArr[index].toCharArray();

            // 문자 배열의 0번째가 맨 앞의 영문 이므로 String으로 변환 후 대문자로 바꾸고 다시 char로 변환
            charArr[0] = String.valueOf(charArr[0]).toUpperCase().charAt(0);

            // 문자열을 다시 저장
            strArr[index] = String.valueOf(charArr);
        }

        // 문자열 배열을 문자열로 합침
        // 연속된 공백을 공백으로 split했기때문에 하나의 공백 추가
        String convertedStr = String.join(" ", strArr);
        
        // StringBuilder에 저장 왜? 문자열 split할때 뒷부분 공백이 유실됨 그래서 공백 채우기 위해 스트링빌더에 저장
        StringBuilder sb = new StringBuilder();
        sb.append(convertedStr);
        
        // 뒷부분 공백 채워 넣기
        if(convertedStr.length() < str.length()){
            sb.append(" ".repeat((str.length() - convertedStr.length())));
        }
        
        return sb;
    }
}