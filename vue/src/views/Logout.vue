<template>
	<h1>Logout</h1>
</template>

<script>
export default {
	created() {
		this.$store.commit("LOGOUT");
		// if (this.$route.path.includes("employees")) {
		// need a way to determine if is logging out an employee or logging out a customer... probably with a query param attached to the end of the logout route
		this.$router.push({ name: "home" });
		// } else {
		// this.$router.push({ name: "home" });
		// }
	},
};
</script>
