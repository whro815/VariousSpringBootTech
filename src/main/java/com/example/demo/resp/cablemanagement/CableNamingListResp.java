package com.example.demo.resp.cablemanagement;

import com.example.demo.dto.cablemanagement.CableNamingDto;
import com.example.demo.resp.BaseResp;
import java.util.List;

public class CableNamingListResp extends BaseResp<List<CableNamingDto>> {
    public CableNamingListResp(List<CableNamingDto> data) {
		super(data);
	}
    
}
