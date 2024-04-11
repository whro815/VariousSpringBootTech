package com.example.demo.resp;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
////@Schema(description = "Result Response")
public class ResultResp extends BaseResp {
    @JsonIgnore
    private Object data;
    public ResultResp(Object data){
        this.data = data;
    }
}
