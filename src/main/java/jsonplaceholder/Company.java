package jsonplaceholder;

import lombok.Data;

//uzycie @data z biblioteki lombok powoduje utworzenie dodatkowych "wirtualnych metod getter and setter"
@Data
public class Company {

    private  String name;
    private  String catchPhrase;
    private  String bs;

}
