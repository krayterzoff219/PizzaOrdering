<template>
    
    <div class="menu-page-filler">

        <div class="header">
            <h1>
                <em>The best menu in town!</em>
            </h1>
        </div>

        <img class="menu-pic-1" src="https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais" alt="pepperoni"/>

        <div class="menu-item-1">
            <h3><em>Pepperoni Perfection</em></h3>
             <p>Savor the irresistible allure of our Pepperoni Perfection, a culinary masterpiece that has stood the test of time. This iconic pizza is a testament to the beauty of simplicity, showcasing the finest ingredients and expert craftsmanship that our kitchen takes immense pride in.</p>
              <div class="price-and-add1">
                <p>$16.99</p>
                <!-- <small-button>Add to order</small-button>      -->
                <button type="submit">Add to Cart</button>
                
           </div>
        </div>

        <img class="menu-pic-2" src="https://img.freepik.com/free-photo/creative-arrangement-with-delicious-pizza_23-2148921354.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais" alt="veggie">

        <div class="menu-item-2">
            <h3><em>Garden Mixer</em></h3>
            <p>The Garden Delight Pizza is a testament to the beauty of nature's bounty and our commitment to bringing you the very best in vegetarian cuisine. Crafted with a passion for flavors and a dedication to quality, this pizza showcases a colorful array of garden-fresh vegetables that burst with freshness in every bite.</p>
           <div class="price-and-add2">
                <p>$16.99</p>
                <!-- <small-button>Add to order</small-button>      -->
                <button type="submit">Add to Cart</button>
                
           </div>
        </div>

        <img class="menu-pic-3" src="https://img.freepik.com/free-photo/front-view-pizza-with-cheese-brown-round-wooden-desk-dark-surface_140725-14476.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais" alt="cheese">

        <div class="menu-item-3">

            <h3><em>Cheese Galore</em></h3>
            <p>Our Classic Margherita Pizza is a culinary masterpiece that pays homage to tradition, capturing the essence of Italian simplicity in every bite. Crafted with the utmost care and precision, this pizza is a celebration of minimalism, where the quality of ingredients takes center stage.</p>


        </div>


        


        <div class="header-pic">
            
        </div>

    </div>



</template>
 

 <script>
    // import SmallButton from '../components/SmallButton.vue';

    // export default{
    //     components: {SmallButton}
     
    // }


 </script>

 <style>

    

    .menu-page-filler{
        /* background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826"); */
       
        justify-content: center;
        width: 97%;
        margin-bottom: 20px;
        display: grid;
        grid-template-columns: 1fr, 1fr;
        grid-template-rows: repeat(5, 1fr);
        grid-template: 
        "header header"
        "peppiz desc1"
        "desc2  vegpiz"
        ;
    }

    .header{
        border-radius: 25px;
        /* border: black solid 5px; */
        width: 97%;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
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

    .price-and-add1{
        display: flex;
        justify-content: center;
        align-items: center;
        justify-content: space-evenly;
        width: auto;
        padding-top: 10px;
        height: 100%;

    }

    .price-and-add2{
        display: flex;
        justify-content: center;
        align-items: center;
        justify-content: space-evenly;
        width: auto;
        padding: 10px;
        height: 100%;
        padding-top: 0px;
    }


    button{
        height: 30px;
        color: white;
        background-color: #124948;


    }
    
    .menu-pic-1{
        grid-area: peppiz;
        display: flex;
        align-items: center;
        width: 70%;
        margin: 120px;
        margin-left: 140px;
        border-radius: 10%;
        border: black solid 10px;
        
    }

    .menu-item-1{
        grid-area: desc1;
        text-align: center;
        padding-left: 5px;
        border-radius: 10%;
        border: black solid 10px;
        font-family: var(--loud-font-family);
        background-color: white;
        display: flex;
        align-items: center;
        flex-direction: column;
        font-size: 25px;
        width: 70%;
        margin: 80px auto;
        
        color: black
    }

    .menu-pic-2{
        grid-area: vegpiz;
        border-radius: 10%;
        width: 500px;
        margin-top: 50px;
        margin-left: auto;
        margin-right: auto;
        border: black solid 10px;
        
    }

    .menu-item-2{
        grid-area: desc2;
        text-align: center;
        display: flex;
        justify-content: center;
        align-items: center;
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

    p{
        padding: 0px 10px;
    }


 </style>