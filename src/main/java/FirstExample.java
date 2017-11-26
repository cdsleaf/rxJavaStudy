import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.stream.IntStream;

public class FirstExample {
    private void emit(){
        Observable.just("Hello", "RxJava 2!!").subscribe(System.out::println);

        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                }
            );
        source.subscribe(data -> System.out.println("Result : "+data));

        int[] arr = {100,200,300};
        Observable<Integer> fromArraySampleSource = Observable.fromArray(toIntegerArray(arr));

        fromArraySampleSource.subscribe(System.out::println);
    }

    private static Integer[] toIntegerArray(int[] intArray){
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }

    public static void main(String args[]){
        FirstExample demo = new FirstExample();
        demo.emit();
    }
}
