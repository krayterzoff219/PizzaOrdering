<template>
	<div class="social-icons">
		<a href="https://twitter.com/"><i class="fa-brands fa-x-twitter"></i></a>
		<a href="https://www.instagram.com/"
			><i class="fa-brands fa-instagram"></i
		></a>
		<a href="https://www.facebook.com/"
			><i class="fa-brands fa-facebook-f"></i
		></a>
	</div>
</template>

<script>
export default {};
</script>

<style scoped>
div.social-icons {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	padding: 5px 20px;
	background-color: transparent;
	border-top-right-radius: 25px;
	border-top-left-radius: 25px;
	gap: 10px;
	background-color: var(--white-color);
}

@media only screen and (min-width: 600px) {
	div.social-icons {
		border-top-left-radius: 0;
		align-self: flex-end;
		border-bottom-left-radius: 25px;
		position: absolute;
	}
}

div.social-icons i {
	color: var(--white-color);
	font-size: 1.5rem;
	padding: 5px;
	margin: 0;
	background-color: var(--dark-color);
	border-radius: 50%;
	width: 2.2rem;
	text-align: center;
}

i::before {
	vertical-align: middle;
}
</style>
