<template>
	<nav>
		<router-link
			class="push-left"
			:to="{ name: 'home' }"
			><img
				src="../assets/logo-no-background.png"
				alt="UpperCrust Pizza Logo"
		/></router-link>
		<router-link :to="{ name: 'home' }">Home</router-link>
		<router-link :to="{ name: 'menu' }">Menu</router-link>
		<router-link :to="{ name: 'about' }">About</router-link>
		<router-link :to="{ name: 'contact' }">Contact</router-link>
		<router-link :to="{ name: 'my-order' }">My Order</router-link>
		<router-link
			v-bind:to="{ name: 'logout' }"
			v-if="$store.state.token != ''"
			>Logout</router-link
		>
	</nav>
</template>

<script>
export default {};
</script>

<style scoped>
nav {
	--edge-padding: 30px;
	--between-padding: 30px;
	--top-bottom-padding: 15px;
	--border-radius: 25px;
	background-color: var(--white-color);
	width: 99%;
	height: 10%;
	position: sticky;
	display: flex;
	align-items: center;
	padding: var(--top-bottom-padding) 0;
	border-bottom: 2px solid var(--dark-color);
	border-radius: var(--border-radius);
	/* border-bottom-right-radius: 25px; */
	margin-bottom: 10px;
	/* margin-top: 5px; */
	margin-right: auto;
	margin-left: auto;
}

nav a {
	padding-right: var(--between-padding);
	color: var(--dark-color);
	text-decoration: none;
	font-family: var(--loud-font-family);
}

nav a:first-child {
	padding-left: var(--edge-padding);
	height: 100%;
}

nav a:last-child {
	padding-right: var(--edge-padding);
}

nav a.push-left {
	margin-right: auto;
}

nav img {
	height: 100%;
}
</style>
