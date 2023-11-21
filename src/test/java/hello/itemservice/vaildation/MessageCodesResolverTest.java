package hello.itemservice.vaildation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required","item");
        // 2가지 메시지를 띄운다.
        for (String message : messageCodes){
            System.out.println("messageCodes = "+ message);
        }
        // Assertions 는 static import 해주면 좋음 alt+enter 누르면 됨
        assertThat(messageCodes).containsExactly("required.item","required");

//        new Object("item",new String[]{"required.item","required"});
    }

    @Test
    void messageCodesResolverField(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required","item","itemName",String.class);
        // for each 문 iter 하고 엔터나 탭 누르면 나옴
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = "+messageCode);
        }
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
