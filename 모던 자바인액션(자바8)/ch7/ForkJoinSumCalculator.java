package Java8.ch7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {    //A recursive result-bearing ForkJoinTask.
    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD=10_000;

    public ForkJoinSumCalculator(long[] numbers){
        this(numbers,0,numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers,int start,int end){
        this.numbers=numbers;
        this.start=start;
        this.end=end;
    }

    @Override
    protected Long compute() {
        int length = end-start;
        if(length<=THRESHOLD){
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,start,start+length/2);

        //Arranges to asynchronously execute this task in the pool the current task is running in
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,start+length/2,end);

        //Long leftResult = leftTask.compute();     //xxxxxxxxxxxx
        Long rightResult = rightTask.compute();

        //Returns the result of the computation when it is done.
        Long leftResult = leftTask.join();
        return leftResult+rightResult;
    }

    private long computeSequentially(){
        long sum=0;
        for(int i=start;i<end;i++) sum+=numbers[i];
        return sum;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1,1000_1000_0).toArray();

        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        //ForkJoinTask
        // : Creates a ForkJoinPool with parallelism equal to Runtime.availableProcessors, using the default thread factory

        //ForkJoinPool.invoke()
        // : Performs the given task, returning its result upon completion
        long startTime =System.currentTimeMillis();
        Long result = new ForkJoinPool().invoke(task);
        long endTime=System.currentTimeMillis();
        System.out.println(result+" "+(endTime-startTime));

        startTime=System.currentTimeMillis();
        long result2=0;
        for(long x:numbers) result2+=x;
        endTime=System.currentTimeMillis();

        System.out.println(result2+" "+(endTime-startTime));


    }

}
