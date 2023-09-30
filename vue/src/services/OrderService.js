import axios from "axios";

export default {
	getPendingOrders() {
		return axios.get("/pending-orders");
	},
	createPendingOrder(order) {

		return axios.post("/orders", order);
	},
	updatePendingOrder(order) {
		return axios.put(`/pending-orders/${order.id}`, order);
	},
};
