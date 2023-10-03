import axios from "axios";

export default {
	getOptions(path) {
		return axios.get(`/${path}`);
	},
	createOption(path, option) {
		return axios.post(`/${path}`, option);
	},
	updateOption(path, option) {
		return axios.put(`/${path}`, option);
	},
};
