import axios from "axios";

export default {
	getMenuItems() {
		return axios.get("/menu");
	},
};
