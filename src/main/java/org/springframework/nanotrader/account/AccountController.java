/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.nanotrader.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAccount(@RequestBody Account account) {
        accountRepository.delete(account.getAccountId());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @RequestMapping(value = "/profile/{profileId}", method = RequestMethod.GET)
    public List<Account> findByAccountProfileId(@PathVariable Long profileId) {
        return accountRepository.findByAccountProfile(profileId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account findAccount(@PathVariable Long id) {
        return accountRepository.findOne(id);
    }
}
