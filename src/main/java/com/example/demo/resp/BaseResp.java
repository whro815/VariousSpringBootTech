package com.example.demo.resp;

//import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResp<T> {    
//    //@Schema(example = "응답코드(000)")
    private String result_cd="000";
//    //@Schema(example = "응답메세지")
    private String result_msg="Successfully saved.";
//    //@Schema(example = "데이터")
    private T data;
    public BaseResp(T data){
        this.data = data;
    }
}
