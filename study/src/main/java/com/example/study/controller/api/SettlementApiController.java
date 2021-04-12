package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.model.entity.Settlement;
import com.example.study.model.network.request.SettlementApiRequest;
import com.example.study.model.network.response.SettlementApiResponse;
import com.example.study.service.SettlementApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* SQL구문
CREATE TABLE IF NOT EXISTS `study`.`settlement`
(   `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
 `price` DECIMAL(12,4) NULL DEFAULT NULL,
 PRIMARY KEY (`id`))
 ENGINE = InnoDB
 DEFAULT CHARACTER SET = utf8mb4
 COLLATE = utf8mb4_bin

*/


@RestController
@RequestMapping("api/settlement")
public class SettlementApiController extends CrudController<SettlementApiRequest, SettlementApiResponse, Settlement> {

    @Autowired
    private SettlementApiLogicService settlementApiLogicService;
}
