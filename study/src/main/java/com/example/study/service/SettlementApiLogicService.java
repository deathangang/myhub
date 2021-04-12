package com.example.study.service;

import com.example.study.model.entity.Settlement;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.SettlementApiRequest;
import com.example.study.model.network.response.SettlementApiResponse;
import com.example.study.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettlementApiLogicService extends BaseService<SettlementApiRequest,SettlementApiResponse,Settlement> {

    @Autowired
    private SettlementRepository settlementRepository;


    @Override
    public Header<SettlementApiResponse> create(Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    public Header<SettlementApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(settlement -> response(settlement))
                .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<SettlementApiResponse> update(Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<SettlementApiResponse> response(Settlement settlement) {

        SettlementApiResponse body = SettlementApiResponse.builder()
                .id(settlement.getId())
                .price(settlement.getPrice())
                .build();

        return Header.OK(body);
    }
}
