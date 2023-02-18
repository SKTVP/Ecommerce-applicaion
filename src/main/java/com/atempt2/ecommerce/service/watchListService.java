package com.atempt2.ecommerce.service;
import com.atempt2.ecommerce.Exceptions.CustomerException;
import com.atempt2.ecommerce.dto.productDTO;
import com.atempt2.ecommerce.dto.watchListDTO;
import com.atempt2.ecommerce.model.User;
import com.atempt2.ecommerce.model.watchList;
import com.atempt2.ecommerce.repository.watchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class watchListService {
    @Autowired
    watchListRepository watchListRepo;
    @Autowired
    productService productservice;

    public void saveitem(watchList watchList1) {
        watchListRepo.save(watchList1);
    }

    private watchListDTO getWatchListDTO(watchList watchList1) {
        if(Objects.isNull(watchList1)){
            throw new CustomerException("watchlist does not exist");
        }

        watchListDTO dto=new watchListDTO();
        dto.setDate(watchList1.getDate());
        dto.setProduct_id(watchList1.getProduct().getId());
        dto.setUser_id(watchList1.getUser().getId());

        return dto;
    }

    public List<productDTO> showWatchListforUser(User user) {

            List<watchList> all=watchListRepo.findAllByUserOrderByDateDesc(user);
            ArrayList<productDTO> final1=new ArrayList<productDTO>();
            for(watchList a: all){
                final1.add(productservice.getProductDTo(a.getProduct()));
            }

            return final1;

    }
}
