package com.creditsaison.omni.enums;

public enum FoodFacilitySearchType {

    APPLICANT_STREET_EXPIRY_DATE,
    APPLICANT_STREET,
    APPLICANT_EXPIRY_DATE,
    STREET_EXPIRY_DATE,
    APPLICANT,
    STREET,
    EXPIRY_DATE;

    public static FoodFacilitySearchType  getFoodFacilitySearchType(boolean isApplicantNamePresent, boolean isStreetNamePresent, boolean isExpiryDatePresent){
        if (isApplicantNamePresent && isStreetNamePresent && isExpiryDatePresent) {
            return FoodFacilitySearchType.APPLICANT_STREET_EXPIRY_DATE;
        }
        if (isApplicantNamePresent && isStreetNamePresent) {
            return FoodFacilitySearchType.APPLICANT_STREET;
        }
        if (isApplicantNamePresent && isExpiryDatePresent) {
            return FoodFacilitySearchType.APPLICANT_EXPIRY_DATE;
        }
        if (isStreetNamePresent && isExpiryDatePresent) {
            return FoodFacilitySearchType.STREET_EXPIRY_DATE;
        }
        if (isApplicantNamePresent) {
            return FoodFacilitySearchType.APPLICANT;
        }
        if (isStreetNamePresent) {
            return FoodFacilitySearchType.STREET;
        }
        return FoodFacilitySearchType.EXPIRY_DATE;
    }
}
