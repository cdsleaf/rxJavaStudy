import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MapExample {

    private void emit(){
        Function<String, String> getDiamond = ball -> ball+"!!!";

        String[] balls = {"1", "2", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .map(getDiamond);
        source.subscribe(System.out::println);

    }

    public static void main(String args[]){
        MapExample demo = new MapExample();
        demo.emit();
    }
}
