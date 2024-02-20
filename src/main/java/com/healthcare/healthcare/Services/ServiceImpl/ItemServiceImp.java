package com.healthcare.healthcare.Services.ServiceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Exceptions.ResourceNotFoundExecption;
import com.healthcare.healthcare.Models.Activity;
import com.healthcare.healthcare.Models.Item;
import com.healthcare.healthcare.Payloads.ResponseActivity;
import com.healthcare.healthcare.Payloads.ResponseItem;
import com.healthcare.healthcare.Repositories.ActivityRepo;
import com.healthcare.healthcare.Repositories.ItemRepo;
import com.healthcare.healthcare.Services.ItemService;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ActivityRepo activityRepo;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseItem createItem(ResponseItem responseItem) {
        Item item = this.modelMapper.map(responseItem , Item.class);
        Activity activity = this.modelMapper.map(responseItem.getActivity(), Activity.class);
        item.setActivity(activity);
        activity.setItem(item);
        Item createdItem = this.itemRepo.save(item);
        Activity createdActivity = this.activityRepo.save(activity);
        ResponseItem result = this.modelMapper.map(createdItem , ResponseItem.class);
        result.setActivity(this.modelMapper.map(createdActivity, ResponseActivity.class));
        return result;
    }

    @Override
    public ResponseItem getItemUsingId(int id) {
        Optional<Item> optional  = this.itemRepo.findById(id);
        if(optional.isPresent()){
            Item item = optional.get();
            ResponseActivity activity = this.modelMapper.map(item.getActivity(), ResponseActivity.class);
            ResponseItem result = this.modelMapper.map(item, ResponseItem.class);
            result.setActivity(activity);
            return result;
        }
        throw new ResourceNotFoundExecption("Item", "id", id);
    }
    
}
