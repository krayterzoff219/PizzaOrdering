import axios from "axios";

export default {
	getSauces() {
		return axios.get("/sauces");
	},
	createSauce(sauce) {
		return axios.post("/sauces", sauce);
	},
	updateSauce(sauce) {
		return axios.put(`/sauces/${sauce.id}`, sauce);
	},
};
