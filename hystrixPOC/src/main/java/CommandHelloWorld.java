
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;


public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {

        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(2000)));
        this.name = name;

    }

    @Override
    protected String run() {
        try {
            Thread.sleep(1900);
        } catch (InterruptedException e) {
            System.out.println("Sleep error");
        }
        return "Hello " + name + "!";
    }

    @Override
    public String getFallback(){
        return "Hello test";
    }


}