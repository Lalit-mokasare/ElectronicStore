package com.lcwd.electronic.store.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ImageNameValidator {




    public class ImageNameValid implements ConstraintValidator<com.lcwd.electronic.store.validate.ImageNameValid,String> {





        private Logger logger= LoggerFactory.getLogger(ImageNameValidator.class);
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {


            logger.info("Message from invalid : {}",value);

            //logic
            if(value.isBlank()) {
                return false;
            }else {
                return  true;

            }
        }
    }



























}
