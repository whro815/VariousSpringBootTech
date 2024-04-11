package com.example.demo.dto.cablemanagement;

import com.example.demo.domain.entity.BaseEntity;
import com.example.demo.domain.entity.CableNamingEntity;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CableNamingDto {

    //JsonAlias : 역직렬화를 할 때 한 개 이상의 이름을 한 객체 필드에 매핑되게 설정
    @JsonAlias("cnid")
    private Long cnid;

    @JsonAlias("pid")
	private String pid;

    @JsonAlias("uid")
	private String uid;

    @JsonAlias("type")
	private String type;

    @JsonAlias("ctype")
    private String ctype;

    @JsonAlias("name")
	private String name;

    @JsonAlias("orderno")
	private Integer orderno;

    @JsonAlias("reg_date")
    private String reg_date;

    @JsonAlias("seq_num")
    private Integer seq_num;

    @JsonAlias("roles")
    @JsonProperty("roles")      // JsonProperty : 직렬화시 설정할 수 잇는 이름을 지정하는 애노테이션
    private List<CableNamingAttributeDto> roles;

    public CableNamingEntity toEntity(){
        return CableNamingEntity.builder()
                            .cnid(cnid)
                            .pid(pid)
                            .uid(uid)
                            .type(type)
                            .ctype(ctype)
                            .name(name)
                            .orderno(orderno)
                            .seq_num(seq_num)
                            .roles(roles)
                            .build();
    }

    @Builder
    public CableNamingDto(Long cnid, String pid, String uid, String type, String ctype, String name, Integer orderno, Integer seq_num, List<CableNamingAttributeDto> roles, String reg_date)
    {
        this.cnid=cnid;
        this.pid=pid;
        this.uid=uid;
        this.type=type;
        this.ctype=ctype;
        this.name=name;
        this.orderno=orderno;
        this.seq_num=seq_num;
        this.roles=roles;
        this.reg_date=reg_date;
    }
}
