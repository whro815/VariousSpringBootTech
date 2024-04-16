package com.example.demo.domain.entity.cablemanagement;

import com.example.demo.domain.entity.BaseEntity;
import com.example.demo.dto.cablemanagement.CableNamingAttributeDto;
import com.example.demo.utils.CableNamingAttributeConverter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Table(name = "TB_CABLE_NAMING")
@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
public class CableNamingEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cnid;
	private String pid;
	private String uid;

	private String type;
	private String ctype;
	private String name;

	private Integer orderno;
	private Integer seq_num;

	@Column(name = "ROLES", columnDefinition = "longtext")
	@Convert(converter = CableNamingAttributeConverter.class)
	private List<CableNamingAttributeDto> roles;

    @Builder
    public CableNamingEntity(Long cnid, String pid, String uid, String type, String ctype, String name, Integer orderno, Integer seq_num, List<CableNamingAttributeDto> roles){
        this.cnid=cnid;
        this.pid=pid;
	    this.uid=uid;
	    this.type=type;
		this.ctype=ctype;
	    this.name=name;
	    this.orderno=orderno;
		this.seq_num=seq_num;
		this.roles=roles;
    }
}
