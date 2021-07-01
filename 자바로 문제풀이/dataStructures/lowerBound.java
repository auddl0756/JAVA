
    //정렬된 list에 대해~
    public static int lowerBound(List<Integer> list,int target){
        int s=0,e=list.size();
        while(s<e){
            int mid=(s+e)/2;
            if(list.get(mid)>=target) e=mid;        //줄일 수 있을 때까지 줄여
            else s=mid+1;
        }
        return e;
    }
