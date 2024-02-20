package com.healthcare.healthcare.Services;

import com.healthcare.healthcare.Payloads.ResponseItem;

public interface ItemService {
    ResponseItem createItem(ResponseItem item);
    ResponseItem getItemUsingId(int id);
}
