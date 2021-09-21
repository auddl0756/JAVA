   private static int[] failTable;

    //패턴(찾을 문자열)에서 실패 시에 어디로 되돌아갈지(어디서부터 다시 탐색을 시작할 지)에 대한 정보를 만들어주는 함수
    private static void makeFailTable(String pattern) {
        int patternLen = pattern.length();
        failTable = new int[patternLen];

        int here = 0;
        for (int nxt = 1; nxt < patternLen; nxt++) {
            for (; here > 0 && pattern.charAt(here) != pattern.charAt(nxt); here = failTable[here - 1]) ;

            if (pattern.charAt(here) == pattern.charAt(nxt)) {
                failTable[nxt] = here + 1;
                here += 1;
            }
        }
    }

    private static List<Integer> matched;

    private static void KMP(String target, String pattern) {
        int targetLen = target.length();
        int patternLen = pattern.length();

        int pi = 0;
        for (int ti = 0; ti < targetLen; ti++) {
            //실패 테이블을 이용해서 매칭될 때 까지 후퇴
            for (; (pi > 0) && (target.charAt(ti) != pattern.charAt(pi)); pi = failTable[pi - 1]) ;

            if (target.charAt(ti) == pattern.charAt(pi)) {
                if (pi == patternLen - 1) { //완전히 매칭됨
                    matched.add(ti - patternLen + 1);
                    pi = failTable[pi];
                } else {    //한 보 전진
                    pi++;
                }
            }
        }
    }
