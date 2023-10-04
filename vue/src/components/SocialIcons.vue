<template>
	<div class="social-icons">
		<a
			class="jump"
			href="https://twitter.com/"
			><i class="fa-brands fa-x-twitter"></i
		></a>
		<a
			class="jump"
			href="https://www.instagram.com/"
			><i class="fa-brands fa-instagram"></i
		></a>
		<a
			class="jump"
			href="https://www.facebook.com/"
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
	border-top-right-radius: var(--section-border-radius);
	border-top-left-radius: var(--section-border-radius);
	gap: 10px;
	background-color: rgba(239, 55, 62, 0.95);
	border-bottom: 2px solid var(--dark-color);
}

@media only screen and (min-width: 600px) {
	div.social-icons {
		border-top-left-radius: 0;
		align-self: flex-end;
		border-bottom-left-radius: var(--section-border-radius);
		position: absolute;
		border-left: 2px solid var(--dark-color);
	}
}
@media only screen and (min-width: 768px) {
	div.social-icons {
		border-bottom-left-radius: 0;
		position: relative;
		border-right: 2px solid var(--dark-color);
		width: 100%;
		justify-content: flex-start;
		background-color: var(--primary-color);
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
