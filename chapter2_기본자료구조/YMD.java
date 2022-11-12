package chapter2_기본자료구조;

class YMD {

    int year; //년
    int month; //월(1-12)
    int day; //일(1-31)
    int daysperMonth[][] =
            {
                    {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},		// 평년
                    {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},		// 윤년
            };
    YMD(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    void after(int n){
        if(n < 0){
            before(-n);
            return;
        }
        int addDay = day + n;
        while(true){
            //윤년 평년인지 판단하는 변수 i
            int i = year%4==0?1:0;
            //달이 넘어가게 되면
            if(addDay > daysperMonth[i][month-1]){
                addDay -= daysperMonth[i][month-1];
                month += 1;
                //년도가 넘어감
                if(month > 12){
                    month = 1;
                    year += 1;
                }
            }
            //달이 안넘어감
            else{
                day = addDay;
                break;
            }
        }
    }

    void before(int n){
        if(n<0){
            after(-n);
            return;
        }
        while (true){
            //윤년 평년인지 판단하는 변수 i
            int i = year%4==0?1:0;
            int beforeMonth = month-1>1?month-1:12;
            if(day + daysperMonth[i][beforeMonth-1] -n <= 0){
                n -= daysperMonth[i][beforeMonth-1];
                month -= 1;
                if(month < 1){
                    year -= 1;
                    month = 12;
                }
            }
            else{
                day = daysperMonth[i][beforeMonth-1] + day - n;
                month -= 1;
                if(month < 1){
                    year -= 1;
                    month = 12;
                }
                break;
            }
        }
    }
}
