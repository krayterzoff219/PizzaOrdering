import axios from "axios";

export default {
	getCrusts() {
		return axios.get("/crusts");
	},
	createCrust(crust) {
		return axios.post("/crusts", crust);
	},
	updateCrust(crust) {
		return axios.put(`/crusts/${crust.id}`, crust);
	},
};
