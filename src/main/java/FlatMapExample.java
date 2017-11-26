import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMapExample {
    private void emit(){
        Function<String, Observable<String>> getDoubleDiamond = ball -> Observable.just(ball+"!!!", ball+"!!!");

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .flatMap(getDoubleDiamond);
        source.subscribe(System.out::println);

    }

    public static void main(String args[]){
        FlatMapExample demo = new FlatMapExample();
        demo.emit();
    }
}
