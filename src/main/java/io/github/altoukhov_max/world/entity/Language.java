/*
 * Copyright 2021 Maxim Altoukhov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.altoukhov_max.world.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "countrylanguage")
@IdClass(value = Language.PrimaryKey.class)
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode // FIXME: Most likely a source of bugs (and performance issues, according to IntelliJ IDEA)
public class Language {

    // Primitives are marked as nullable/non-nullable simply to stay consistent with the related table creation DLL query

    @NoArgsConstructor
    @EqualsAndHashCode
    public static class PrimaryKey implements Serializable {

        private String name;
        private Country country;
    }

    @Id
    @Column(name = "language", length = 30, nullable = false)
    private String name;

    @Id
    @ManyToOne
    @JoinColumn(name = "countrycode", referencedColumnName = "code", nullable = false)
    private Country country;

    @Column(name = "isofficial", nullable = false)
    private boolean official;

    @Column(name = "percentage", precision = 4, scale = 1, nullable = false)
    private float percentage;

    // Non-generated to provide a simpler impl and avoid performance issues related to foreign key loading (according to IntelliJ IDEA)
    @Override
    public String toString() {
        return name + " (" + country.getName() + ')';
    }
}
