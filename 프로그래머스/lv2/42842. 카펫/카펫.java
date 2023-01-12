class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int brownWide = (brown-4)/2;
        for(int i = 1 ; i < brownWide ; i++){
            if(i*(brownWide-i)==yellow){
                answer[0] = brownWide-i+2;
                answer[1] = i+2;
                break;
            }
        }
        return answer;
    }
}