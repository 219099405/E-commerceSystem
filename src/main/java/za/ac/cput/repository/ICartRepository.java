package za.ac.cput.repository;

import za.ac.cput.domain.Cart;

import java.util.List;

public interface ICartRepository extends IRepository<Cart,String>{

    List<Cart> getAll();
}
