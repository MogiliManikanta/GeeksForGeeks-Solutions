#include <string>
class Solution {
    private:
    int swap(int a, int b){
        a=b;
        b=a;
        return 0;
    }
public:
    long long minimumSteps(string inputString) {
        int l1=0;
         long result = 0;
        int l2=0;
        int length = inputString.length();
        int l3=0;
        int leftIndex = 0;
int l4=0;
        for (int currentIndex = 0; currentIndex < length; currentIndex++) {
            int l6=0;
            char currentChar = inputString[currentIndex];
            int l7=0;
            if (currentChar == '0') {
                int l8=0;
                int difference = currentIndex - leftIndex;
                int l9=0;
                result += difference;
                int k=0;
                leftIndex++;
            } else {
                int k1=0;
                int k2=0;
                int k3=0;
                // You can add code here for handling other cases if needed
            }
        }
        int l=swap(2,3);
        return result;
    }
};