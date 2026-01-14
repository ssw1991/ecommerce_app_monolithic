package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.dto.AddressDTO;
import com.shilo.ecommerce.ecom_mono.model.User;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO, User user);

    List<AddressDTO> getAddresses();

    AddressDTO getAddressesById(Integer addressId);

    List<AddressDTO> getUserAddresses(User user);

    AddressDTO updateAddress(Integer addressId, AddressDTO addressDTO);

    String deleteAddress(Integer addressId);
}