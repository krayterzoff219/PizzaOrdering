<template>
    
        <div class="pendingList" >
            
            <div> 
                <span>{{currentOrder.orderId}}</span>
                <br>
                <span>{{currentOrder.status}}</span>
                <br>
                
            </div>

            <router-link to="/employee-order-view">
            <small-button buttonText="View"/>
            </router-link>
                
           
           

            <select v-if="isLoaded" v-model="currentOrder.status" >
                <option v-for="stat in possibleStatus" 
                :key="stat"
                :value="stat.toLowerCase()">{{stat}}
                </option>
            </select>

		</div>

   


</template>

<script>
import SmallButton from './SmallButton.vue'

export default{
    components: { SmallButton },

    data(){

        return {
            possibleStatus: [
                "Pending",
                "Cancelled",
                "Ready",
                "Complete"
            ],

            currentOrder: {
                orderId: -1,
                status: "",
                email: "",
                address: "",
                phone: -1,
                isDelivery: false,
                menuItems: {},
                customPizzas: {}
            },
            isLoaded: false
        }
    },

    props: ["order"],

    created(){
        this.initializeOrder();
        this.isLoaded = true;
    },
    
    methods: {
        initializeOrder() {
			const { orderId, status, email, address, phone, isDelivery, menuItems, customPizzas} = this.order;

			this.currentOrder.orderId = orderId;
            this.currentOrder.status = status;
            this.currentOrder.email = email;
            this.currentOrder.address = address;
            this.currentOrder.phone = phone;
            this.currentOrder.isDelivery = isDelivery;
            this.currentOrder.menuItems = menuItems;
            this.currentOrder.customPizzas = customPizzas;
		},
    }

}

</script>

<style scoped>

div.pendingList {
	display: grid;
	grid-template-columns: 2fr 2fr 1fr;
	width: 100%;
	justify-content: center;
	padding: 15px 10px;
    margin: 10px auto;
    border-bottom: black solid 3px;
}

</style>