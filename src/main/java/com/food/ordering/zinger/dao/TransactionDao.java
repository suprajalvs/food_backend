package com.food.ordering.zinger.dao;

import com.food.ordering.zinger.column.TransactionColumn;
import com.food.ordering.zinger.model.TransactionModel;
import com.food.ordering.zinger.query.TransactionQuery;
import com.food.ordering.zinger.rowMapperLambda.TransactionRowMapperLambda;
import com.food.ordering.zinger.utils.ErrorLog;
import com.food.ordering.zinger.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    

    public Response<String> insertTransactionDetails(TransactionModel transactionModel) {
        Response<String> response = new Response<>();

        try {
            MapSqlParameterSource parameter = new MapSqlParameterSource()
                    .addValue(TransactionColumn.transactionId, transactionModel.getTransactionId())
                    .addValue(TransactionColumn.bankTransactionId, transactionModel.getBankTransactionId())
                    .addValue(TransactionColumn.currency, transactionModel.getCurrency())
                    .addValue(TransactionColumn.responseCode, transactionModel.getResponseCode())
                    .addValue(TransactionColumn.responseMessage, transactionModel.getResponseMessage())
                    .addValue(TransactionColumn.gatewayName, transactionModel.getGatewayName())
                    .addValue(TransactionColumn.bankName, transactionModel.getBankName())
                    .addValue(TransactionColumn.paymentMode, transactionModel.getPaymentMode())
                    .addValue(TransactionColumn.checksumHash, transactionModel.getChecksumHash());

            int transactionResult = namedParameterJdbcTemplate.update(TransactionQuery.insertTransaction, parameter);

            if (transactionResult > 0) {
                response.setCode(ErrorLog.CodeSuccess);
                response.setMessage(ErrorLog.Success);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public Response<TransactionModel> getTransactionDetails(String id) {
        Response<TransactionModel> response = new Response<>();
        TransactionModel transactionModel = null;


        try {
            MapSqlParameterSource parameter = new MapSqlParameterSource()
                    .addValue(TransactionColumn.transactionId, id);

            try {
                transactionModel = namedParameterJdbcTemplate.queryForObject(TransactionQuery.getTransaction, parameter, TransactionRowMapperLambda.transactionRowMapperLambda);
            }
            catch (Exception e){
                e.printStackTrace();
            }

            if (transactionModel != null) {
                response.setCode(ErrorLog.CodeSuccess);
                response.setMessage(ErrorLog.Success);
                response.setData(transactionModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
