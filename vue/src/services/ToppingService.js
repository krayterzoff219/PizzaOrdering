import axios from "axios";

export default {
	getToppings() {
		return axios.get("/toppings");
	},
	createTopping(topping) {
		return axios.post("/toppings", topping);
	},
	updateTopping(topping) {
		return axios.put(`/toppings/${topping.id}`, topping);
	},
};
