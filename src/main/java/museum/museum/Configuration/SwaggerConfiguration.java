package museum.museum.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Museum api document")
                .description("参数token放在请求头内\r\n调用登录接口获得token")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        /*ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("access token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数*/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描basePackage包下面的“/rest/”路径下的内容作为接口文档构建的目标
                .apis(RequestHandlerSelectors.basePackage("museum.museum"))
                .paths(PathSelectors.regex("/.*"))
                .build();
                //.globalOperationParameters(pars);
    }
}
