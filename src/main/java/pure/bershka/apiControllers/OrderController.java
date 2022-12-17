package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pure.bershka.business.abstracts.OrderService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.core.utilities.result.SuccessDataResult;
import pure.bershka.entities.concretes.Order;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;
    
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/give-order")
    public Result giveOrder(@RequestBody Order order){
        return this.orderService.giveOrder(order);
    }
    @GetMapping("/get-all")
    public DataResult<List<Order>> getAll(){
        return this.orderService.getAllOrdersForAdmin();
    }
    @DeleteMapping("/delete")
    public Result delete(int orderId){
        return this.orderService.deleteOrder(orderId);
    }
    @PutMapping("/update")
    public Result update(int orderId, @RequestBody Order order){
        return this.orderService.updateOrder(orderId, order);
    }
}
