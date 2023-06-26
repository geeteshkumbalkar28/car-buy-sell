package com.SellBuyCar.Interface;

import com.SellBuyCar.dto.DealerDto;
import com.SellBuyCar.dto.ResponseDealerDto;

import java.util.List;

public interface IDealer {
    public String adDealer(DealerDto dealerDto);

    public List<ResponseDealerDto> getDealers(int pageNo);

    public String editDealer(DealerDto dealerDto,int id);

    public String removeDealers(int id);
}
