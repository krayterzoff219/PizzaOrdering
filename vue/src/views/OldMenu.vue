<template>
	<div class="menu-page-filler">
		<div class="header">
			<h1>
				<em>The best menu in town!</em>
			</h1>
		</div>

		<img
			class="menu-pic-1"
			src="https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais"
			alt="pepperoni" />

		<div class="menu-item-1">
			<h3><em>Pepperoni Perfection</em></h3>
			<p>
				Savor the irresistible allure of our Pepperoni Perfection, a culinary
				masterpiece that has stood the test of time. This iconic pizza is a
				testament to the beauty of simplicity, showcasing the finest ingredients
				and expert craftsmanship that our kitchen takes immense pride in.
			</p>
			<div class="price-and-add1">
				<p>$16.99</p>
				<!-- <small-button>Add to order</small-button>      -->
				<button type="submit">Add to Order</button>
			</div>
		</div>

		<img
			class="menu-pic-2"
			src="https://img.freepik.com/free-photo/creative-arrangement-with-delicious-pizza_23-2148921354.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais"
			alt="veggie" />

		<div class="menu-item-2">
			<h3><em>Garden Mixer</em></h3>
			<p>
				The Garden Delight Pizza is a testament to the beauty of nature's bounty
				and our commitment to bringing you the very best in vegetarian cuisine.
				Crafted with a passion for flavors and a dedication to quality, this
				pizza showcases a colorful array of garden-fresh vegetables that burst
				with freshness in every bite.
			</p>
			<div class="price-and-add2">
				<p>$16.99</p>
				<!-- <small-button>Add to order</small-button>      -->
				<button type="submit">Add to Order</button>
			</div>
		</div>

		<img
			class="menu-pic-3"
			src="https://img.freepik.com/free-photo/front-view-pizza-with-cheese-brown-round-wooden-desk-dark-surface_140725-14476.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais"
			alt="cheese" />

		<div class="menu-item-3">
			<h3><em>Cheese Galore</em></h3>
			<p>
				Our Classic Margherita Pizza is a culinary masterpiece that pays homage
				to tradition, capturing the essence of Italian simplicity in every bite.
				Crafted with the utmost care and precision, this pizza is a celebration
				of minimalism, where the quality of ingredients takes center stage.
			</p>
			<div class="price-and-add3">
				<p>$16.99</p>
				<!-- <small-button>Add to order</small-button>      -->
				<button type="submit">Add to Order</button>
			</div>
		</div>

		<img
			class="menu-pic-4"
			src="https://img.freepik.com/premium-photo/pizza-fast-food-cooking_26791-161.jpg?size=626&ext=jpg&ga=GA1.2.481236351.1695826882&semt=ais"
			alt="meat-lovers" />

		<div class="menu-item-4">
			<h3><em>Meat Feast Pizza</em></h3>
			<p>
				The Ultimate Meat Feast Pizza is an unapologetic celebration of all
				things carnivorous. Crafted for the meat lover in you, this pizza offers
				a carnivore's dream on a plate. Each bite is a flavorful adventure
				through a tantalizing assortment of premium meats, expertly prepared to
				perfection.
			</p>
			<div class="price-and-add4">
				<p>$16.99</p>
				<!-- <small-button>Add to order</small-button>      -->
				<button type="submit">Add to Order</button>
			</div>
		</div>

		<img
			class="menu-pic-5"
			src="https://img.freepik.com/free-photo/meat-pizza-bell-pepper-basil-arugula-tomato-cheese-onion-top-view_141793-2772.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais"
			alt="pepperoni" />

		<div class="menu-item-5">
			<h3><em>Philly Cheeza</em></h3>
			<p>
				Our Philly Cheesesteak Pizza is a culinary adventure that marries the
				best of two worlds: the bold, savory tradition of the Philly cheesesteak
				and the comforting, cheesy goodness of pizza. This delectable creation
				is a mouthwatering journey through flavor and texture, bringing the
				spirit of Philadelphia to your plate.
			</p>
			<div class="price-and-add5">
				<p>$16.99</p>
				<!-- <small-button>Add to order</small-button>      -->
				<button type="submit">Add to Order</button>
			</div>
		</div>

		<img
			class="menu-pic-6"
			src="https://img.freepik.com/free-photo/side-view-chicken-pizza-tray-with-salad-table_141793-12982.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais" />

		<div class="menu-item-6">
			<h3><em>Yard Bird</em></h3>
			<p>
				Our Yard Bird Pizza is a tantalizing fusion of flavors that will
				transport your taste buds to the heart of a backyard barbecue. This
				delectable creation combines succulent pieces of marinated chicken with
				the rich and tangy goodness of barbecue sauce, all atop a perfectly
				baked pizza crust.
			</p>
			<div class="price-and-add6">
				<p>$16.99</p>
				<!-- <small-button>Add to order</small-button>      -->
				<button type="submit">Add to Order</button>
			</div>
		</div>
	</div>
</template>

<script>
// import SmallButton from '../components/SmallButton.vue';

// export default{
//     components: {SmallButton}

// }
</script>

<style scoped>
.menu-page-filler {
	/* background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826"); */

	justify-content: center;
	margin-right: auto;
	margin-left: auto;
	width: 97%;
	margin-bottom: 20px;
	display: grid;
	grid-template-columns: 1fr, 1fr;
	grid-template-rows: repeat(5, 1fr);
	grid-template:
		"header header"
		"peppiz desc1"
		"desc2  vegpiz"
		"chspiz desc3"
		"desc4   mtpiz"
		"philpza desc5"
		"desc6   yrdbrd";
}

.header {
	border-radius: 25px;
	/* border: black solid 5px; */
	width: 97%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 120px;
	font-family: var(--loud-font-family);
	/* background-color: black; */
	/* background-image: url("https://img.freepik.com/free-photo/dark-concrete-texture-background_24837-659.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais"); */
	background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826");
	grid-area: header;
	text-align: center;
	padding: 20px;
	font-weight: bolder;
	font-size: 50px;
	color: black;
	/* border:white solid 10px; */
}

.price-and-add1 {
	display: flex;
	justify-content: center;
	align-items: center;
	justify-content: space-evenly;
	width: auto;
	padding-top: 10px;
	height: 100%;
}

.price-and-add2 {
	display: flex;
	justify-content: center;
	align-items: center;
	justify-content: space-evenly;
	width: auto;
	padding: 10px;
	height: 100%;
	padding-top: 0px;
	box-sizing: border-box;
}
button {
	height: 30px;
	color: white;
	background-color: #124948;
}

.menu-pic-1 {
	grid-area: peppiz;
	display: flex;
	align-items: center;
	width: 70%;
	margin: 80px;
	margin-left: 120px;
	border-radius: 10%;
	border: black solid 10px;
}

.menu-item-1 {
	grid-area: desc1;
	text-align: center;
	/* padding-left: 5px; */
	border-radius: 5%;
	border: black solid 10px;
	font-family: var(--loud-font-family);
	background-color: white;
	display: flex;
	/* align-items: center; */
	flex-direction: column;
	font-size: 25px;
	width: 90%;
	height: 390px;
	margin: 80px 80px 80px auto;
	color: black;
}

.menu-pic-2 {
	grid-area: vegpiz;
	border-radius: 5%;
	margin-top: 30px;
	margin-left: auto;
	margin-right: auto;
	border: black solid 10px;
	width: 600px;
}

.menu-item-2 {
	grid-area: desc2;
	text-align: center;
	display: flex;
	justify-content: center;
	/* align-items: center; */
	flex-direction: column;
	background-color: white;
	width: 90%;
	font-family: var(--loud-font-family);
	font-size: 25px;
	padding: 0 20px;
	margin: 25px;
	margin-left: 80px;
	border-radius: 25px;
	border: black solid 10px;
}

.menu-pic-3 {
	grid-area: chspiz;
	width: 600px;
	border: black solid 10px;
	border-radius: 20px;
	margin-top: 55px;
	margin-right: auto;
	margin-left: auto;
}

.menu-item-3 {
	grid-area: desc3;
	background-color: white;
	width: 90%;
	border-radius: 5%;
	border: black solid 10px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
	margin: 55px auto;
	font-size: 25px;
}

.price-and-add3 {
	display: flex;
	justify-content: center;
	align-items: center;
	justify-content: space-evenly;
	width: auto;
	padding: 10px;
	height: 100%;
	padding-top: 0px;
	box-sizing: border-box;
}

.menu-item-4 {
	grid-area: desc4;
	background-color: white;
	width: 90%;
	border-radius: 5%;
	border: black solid 10px;
	margin: 50px auto;
	display: flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
	margin: 50px auto;
	font-size: 25px;
}

.menu-pic-4 {
	grid-area: mtpiz;
	width: 600px;
	height: 400px;
	border: black solid 10px;
	border-radius: 5%;
	margin: 60px auto;
}

.price-and-add4 {
	display: flex;
	justify-content: center;
	align-items: center;
	justify-content: space-evenly;
	width: auto;
	padding: 10px;
	height: 100%;
	padding-top: 0px;
	box-sizing: border-box;
}

.menu-pic-5 {
	grid-area: philpza;
	height: 400px;
	width: 570px;
	border: black solid 10px;
	border-radius: 5%;
	margin: 60px auto;
}

.menu-item-5 {
	grid-area: desc5;
	background-color: white;
	width: 90%;
	border-radius: 5%;
	border: black solid 10px;
	margin: 50px auto;
	display: flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
	margin: 50px auto;
	font-size: 25px;
}

.price-and-add5 {
	display: flex;
	justify-content: center;
	align-items: center;
	justify-content: space-evenly;
}

.menu-item-6 {
	grid-area: desc6;
	background-color: white;
	width: 90%;
	border-radius: 5%;
	border: black solid 10px;
	margin: 50px auto;
	display: flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
	font-size: 25px;
}

.menu-pic-6 {
	grid-area: yrdbrd;
	border-radius: 5%;
	border: black solid 10px;
	margin: 50px auto;
}

.price-and-add6 {
	display: flex;
	justify-content: center;
	align-items: center;
	justify-content: space-evenly;
}

p {
	padding: 0px 10px;
	box-sizing: border-box;
}
</style>
