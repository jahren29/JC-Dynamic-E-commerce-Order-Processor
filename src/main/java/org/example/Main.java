package org.example;

import java.util.Scanner;

public class Main {

    static void stringComparison(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n----- String Equality Demo -----");
        System.out.print("Enter first string for comparison: ");
        String string1 = scan.next();
        System.out.print("Enter second string for comparison: ");
        String string2 = scan.next();

        System.out.println("String 1: " + string1);
        System.out.println("String 2: " + string2);
        System.out.println();

        boolean doubleEqualsResult= (string1 == string2);
        boolean dotEqualsResult = (string1.equals(string2));
        boolean dotEqualsIgnoreCasing = (string1.equalsIgnoreCase(string2));

        System.out.println("\nString 1 == String 2: " + doubleEqualsResult + " (Compares references, which are different for user input strings)");
        System.out.println("String 1 .equals() String 2: " + dotEqualsResult + " (Content is different due to case)");
        System.out.println("String 1 .equalsIgnoreCase() String 2: " + dotEqualsIgnoreCasing + " (Content is identical, ignoring case)");
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("----- Enter Order Details -----");

        System.out.print("Enter unit price: ");
        double unitPrice = scan.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = scan.nextInt();

        System.out.print("Is customer a member (true/false)?: ");
        boolean membership = scan.nextBoolean();

        System.out.print("Enter customer tier (Regular, Silver, Gold): ");
        String customerTier = scan.next();

        System.out.print("Enter Shipping zone (ZoneA, ZoneB, ZoneC, Unknown): ");
        String shippingZone = scan.next();

        System.out.print("Enter discount code (SAVE10, FREESHIP, or \"\" for none):");
        String discountCode = scan.next();

        System.out.println("\n----- Order Details -----");
        System.out.println("Unit price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Is Member: " + membership);
        System.out.println("Customer Tier: " + customerTier);
        System.out.println("Shipping Zone: " + shippingZone);
        System.out.println("Discount Code: " + discountCode);


        System.out.println("\n----- Calculation Steps -----");

        double subTotal = unitPrice * quantity;
        System.out.println("Initial Subtotal: " + subTotal);


        double discountTier = 0;
        double tierDiscountedAmount = 0;
        if(customerTier.equals("Gold")){
            discountTier = 15;
            tierDiscountedAmount =  subTotal * (discountTier / 100);
        }else if(customerTier.equals("Silver")){
            discountTier = 10;
            tierDiscountedAmount =  subTotal * (discountTier / 100);
        }else{
            discountTier = 0;
            tierDiscountedAmount =  subTotal * (discountTier / 100);
        }

        double afterTierDiscount = subTotal - tierDiscountedAmount;

        System.out.println("After Tier Discount " + customerTier + " - " + discountTier + "% : "+afterTierDiscount);

        double quantityDiscount = 0;

        if(quantity >= 5){
            quantityDiscount = 5;

        }
        double initialAmountWithQuantityDiscount = afterTierDiscount * (quantityDiscount / 100);
        double amountAfterQuantityDiscount = afterTierDiscount - initialAmountWithQuantityDiscount;

        System.out.println("After Quantity Discount (5% for >=5 items): " + amountAfterQuantityDiscount);

       double amountAfterPromotionCode = 0;
       double shippingCost = 0;
        if(discountCode.equals("SAVE10") && amountAfterQuantityDiscount > 75.00){
            amountAfterPromotionCode = amountAfterQuantityDiscount - 10;
        } else{
            amountAfterPromotionCode = amountAfterQuantityDiscount;
        }

        System.out.println("After Promotional Code (SAVE10 for >$75): " + amountAfterPromotionCode);

        double newAmountWithSurcharge = (amountAfterPromotionCode < 25) ? amountAfterPromotionCode + 3 : amountAfterPromotionCode +0;

        System.out.println("After Small Order Surcharge (if applicable): " + newAmountWithSurcharge);

        double totalAmount = 0;
        if(discountCode.equalsIgnoreCase("FREESHIP")){
            shippingCost = 0.0;
            System.out.println("Shipping Cost: " + shippingCost + " "+shippingZone);
            totalAmount = newAmountWithSurcharge + shippingCost;
            System.out.println("\nFinal Order Total: " + totalAmount);
        }else {
            switch (shippingZone) {
                case "ZoneA":
                    shippingCost = 5;
                    System.out.println("\nShipping Cost: " + shippingCost + " ZoneA");
                    totalAmount = newAmountWithSurcharge + shippingCost;
                    System.out.println("\nFinal Order Total: " + totalAmount);
                    break;

                case "ZoneB":
                    shippingCost = 12.50;
                    System.out.println("\nShipping Cost: " + shippingCost + " ZoneB");
                    totalAmount = newAmountWithSurcharge + shippingCost;
                    System.out.println("\nFinal Order Total: " + totalAmount);
                    break;

                case "ZoneC":
                    shippingCost = 20.00;
                    System.out.println("\nShipping Cost: " + shippingCost + " ZoneC");
                    totalAmount = newAmountWithSurcharge + shippingCost;
                    System.out.println("\nFinal Order Total: " + totalAmount);
                    break;
                default:
                    shippingCost = 25.00;
                    System.out.println("\nShipping Cost: " + shippingCost + " Unknown");
                    totalAmount = newAmountWithSurcharge + shippingCost;
                    System.out.println("\nFinal Order Total: " + totalAmount);
                    break;


            }


        }


                stringComparison();



    }

}