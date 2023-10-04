<template>
    


    <section id="employee-order-view-section">
       
       <div>
            <horizontal-hero></horizontal-hero>
            <h2>Order View</h2>

            <view-details-item
            id="details-section"
            v-for="Item of currentOrder.menuItems"
            :key="Item.id"
            :menuItem = "Item"
            :order="currentOrder"/>


            
       </div>

    </section>


</template>

<script>
import HorizontalHero from '../components/HorizontalHero.vue'
import ViewDetailsItem from '../components/ViewDetailsItem.vue'



export default{

    components: {
        HorizontalHero, ViewDetailsItem
    },

    data(){
        return{
            currentOrder: {
                orderId: -1,
                status: "Pending",
                email: "",
                address: "test add",
                phone: -1,
                isDelivery: false,
                menuItems: {},
                customPizzas: {}
            }
        }
    },

    created(){
        console.log(this.$store.state.pendingOrders);
        const order = this.$store.state.pendingOrders.filter(
            (myOrder) => myOrder.orderId == 1
        );
        console.log(order);
        this.currentOrder.orderId = order[0].orderId;
        this.currentOrder.status = order[0].status;
        this.currentOrder.email = order[0].email;
        this.currentOrder.address = order[0].address;
        this.currentOrder.phone = order[0].phone;
        this.currentOrder.isDelivery = order[0].isDelivery;
        this.currentOrder.menuItems = order[0].menuItems;
        this.currentOrder.customPizzas = order[0].customPizzas;

    }

}
</script>

<style scoped>


#details-section{
    
}

</style>
